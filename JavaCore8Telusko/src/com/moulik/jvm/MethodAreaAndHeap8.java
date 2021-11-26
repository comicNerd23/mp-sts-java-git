package com.moulik.jvm;

/**
 * We have Method Area and Heap.
 * When we say that we store objects (via new, arrays, class objects) on heap, that means we only store the instance 
 * variables on the heap. JVM allocates space on the heap based on how much instance data it contains (number of instance
 * variables and types of instance variables). The methods are actually associated with the class and not the object. So,
 * it is class data and hence is stored on the Method Area. Not only Method code but method meta information such as 
 * field name, field type and other things.
 * 
 * When we create an instance of a class, following are some of the steps that are followed.
 * The Classloader checks if the Class object for that particular class is already present on the heap. If it is not there,
 * the classloader would then create the Class object in the heap and corresponding class data in the method area. Then 
 * JVM would also create a new object/instance of that class and store that on the heap. 
 * Now if a new object of the same class is to be created, then only the object will be created on the heap since the 
 * classloader already knows that the class data and class object are already present on the method area and heap resp.
 * Similarly, other objects and class data and class objects are created in the memory. 
 * Note that there are many pointers between the method area and heap. 
 * One is Object instance in heap pointing to the class data in the method area. 
 * Second is a bidirectional relationship between class data in method area and class object in the heap.
 * 
 * Method Area:
 * 	General things that are present in method area are:
 * 	* Meta info (related to class) like
 * 			Fully qualified Names of type, superclass or superinterface;
 * 			whether class is Class or Interface;
 * 			class Type modifier: abstract, final, public
 * 
 * 	This is basically the information given by class object. That is why, there is a reference from Class object in heap
 *  to class data in method area.
 *  
 *  * Reference to Class Object (on heap)
 *  The connection between class object and class data is bidirectional. That means a reference must be there
 *  from Class data to class object as well. This reference is needed to have access to class object. E.g During Class 
 *  Loading process, Classloader first checks if class object for that type is already on heap. For that it may actually
 *  search the method area to see if the class data for that type exists. And if does exist, it would then simply return
 *  the reference to the class object.
 *  
 *  * Field (meta) Info
 *  		like Name and Type
 *  		Modifiers: static, final, access modifiers, transient, volatile
 *  
 *  Other than field meta info, if instance variable is a primitive, then its value is also stored on the heap. But if the 
 *  static variable is primitive, then its value is stored in method area.
 *  If variable (instance or static) is an object, then that object is stored on the heap. But the reference of the object
 *  will be stored in the method area for static variables and the reference of the object for instance variable is most
 *  likely stored on the heap. 
 *  
 *  * Runtime Constant Pool
 *  		literals (string or primitives)
 *  		symbolic references
 *  
 *  * Method (meta) Info
 *  		like Name
 *  		Return Type
 *  		Number and Types of Parameters
 *  		Modifiers: static, final, access modifiers, abstract, synchronized, native
 *  		Method Bytecode (corresponding to method's body)
 *  
 *  * Method Table (array of references to instance methods)
 *  		
 * This table is used during method invocation process, ie, when an instance method is invoked on an object, then the 
 * method table will used to find the method code that needs to be executed. This is one advantage for having a reference
 * from an object on the heap to the class data. So invoking a method on an object, JVM would simply follow the pointer
 * from the object to the class data and then use the method table to find the reference to the target method code.
 * Note that method table will also include references to any method inherited from superclasses.
 * 
 * PermGen area to Metaspace
 * 	Permanent Generation space
 * 	Removed completely from Java 8
 * 		It is now part of Native Heap
 * 		It is called Metaspace
 * Advantages:
 * 	For PermGen, there was a default max size set; if that max size was reached, An OutOfMemoryError would be generated.
 * 	Now, it is less likely because now System memory is the limit. 
 * 	This has also improved GC process performance
 * 
 * Runtime Type Information (RTTI)
 * 	* Invoke method code in method area (from Method table reference from object) at runtime is called RTTI
 * 	* check correctness of cast
 * 		Superclass obj = new Subclass();
 * 		Subclass subObj = (Subclass) obj;
 * 			In such piece of code, whether cast is valid or not is known only at runtime. And for it the class data of the 
 * 		object is consulted at runtime.
 * 	* Perform instanceof checks
 * 		subObj instanceof Subclass
 * 
 * Further References:
 * Below link is very good and highly referenced article. Check it out in free time
 *		http://www.ibm.com/developerworks/library/j-nativememory-linux/jnativememory-linux-pdf.pdf 
 * Below thread on SO nicely explains user space & kernel space
 *		http://stackoverflow.com/questions/17208648/linux-kernel-space-and-userspace 
 * Below link gives a nice description of what kernel is. 
 * 		http://www.linfo.org/kernel.html
 *  
 * 
 *
 */
public class MethodAreaAndHeap8 {

}
