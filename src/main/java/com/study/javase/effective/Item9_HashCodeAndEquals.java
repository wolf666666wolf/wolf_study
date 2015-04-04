package com.study.javase.effective;
/**
 * 1. You must override hashCode in every class that overrides equals
 * 
 * a. Compute an int hash code c for the field:
	i. If the field is a boolean, compute (f ? 1 : 0).
	ii. If the field is a byte, char, short, or int, compute (int) f.
	iii. If the field is a long, compute (int) (f ^ (f >>> 32)).
	iv. If the field is a float, compute Float.floatToIntBits(f).
	v. If the field is a double, compute Double.doubleToLongBits(f), and
		then hash the resulting long as in step 2.a.iii.
		vi. If the field is an object reference and this class’s equals method
		compares the field by recursively invoking equals, recursively
		invoke hashCode on the field. If a more complex comparison is
		required, compute a “canonical representation” for this field and
		invoke hashCode on the canonical representation. If the value of the
		field is null, return 0 (or some other constant, but 0 is traditional).
		48 CHAPTER 3 METHODS COMMON TO ALL OBJECTS
		vii. If the field is an array, treat it as if each element were a separate field.
		That is, compute a hash code for each significant element by applying
		these rules recursively, and combine these values per step 2.b. If every
		element in an array field is significant, you can use one of the
		Arrays.hashCode methods added in release 1.5.
b. Combine the hash code c computed in step 2.a into result as follows:
	result = 31 * result + c;
 *
 */
public class Item9_HashCodeAndEquals {
	private  short areaCode;
	private  short prefix;
	private  short lineNumber;
	
	
	@Override 
	public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
	}
}
