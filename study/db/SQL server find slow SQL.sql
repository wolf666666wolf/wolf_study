SELECT total_elapsed_time/execution_count average_elapsed_time,

				total_elapsed_time,

				total_worker_time,
				
        execution_count,

        total_physical_reads,  

        total_logical_reads,  

        total_logical_writes,
        
        --db_name(st.dbid) as [database name],

				--object_name(st.objectid, st.dbid) as [object name],
        
        SUBSTRING(st.text, (qs.statement_start_offset/2) + 1,

        ((CASE statement_end_offset 

          WHEN -1 THEN DATALENGTH(st.text)

          ELSE qs.statement_end_offset END 

            - qs.statement_start_offset)/2) + 1) SQL_text

FROM sys.dm_exec_query_stats AS qs

CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) st

where SUBSTRING(st.text, (qs.statement_start_offset/2) + 1,

        ((CASE statement_end_offset 

          WHEN -1 THEN DATALENGTH(st.text)

          ELSE qs.statement_end_offset END 

            - qs.statement_start_offset)/2) + 1) not like '%fetch%'


ORDER BY total_elapsed_time/execution_count DESC;

