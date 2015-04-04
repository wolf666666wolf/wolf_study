DBCC FREEPROCCACHE; -- clear the query plan cache

SELECT          
         qs.execution_count,  qs.creation_time, qs.last_execution_time,  
         DatabaseName = DB_NAME(qp.dbid),  ObjectName = OBJECT_NAME(qp.objectid), 
         StatementDefinition = 
         SUBSTRING ( 
                        st.text, 
                        ( qs.statement_start_offset / 2) + 1, 
                       (       ( 
                         CASE qs.statement_end_offset 
                         WHEN -1 THEN DATALENGTH(st.text) 
                         ELSE qs.statement_end_offset 
                         END - qs.statement_start_offset 
                                ) / 2 
                       ) + 1 
                ), 
         st.text, total_elapsed_time,  (total_elapsed_time/execution_count) as time_per_run 
 FROM    sys.dm_exec_query_stats AS qs 
             CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) AS st 
             CROSS APPLY sys.dm_exec_query_plan (qs.plan_handle) qp 
 WHERE 
         st.encrypted = 0 
 ORDER BY time_per_run DESC 