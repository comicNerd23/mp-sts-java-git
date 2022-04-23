package com.moulik.java8;


/**
 * 1. Files.list(Path dir) that returns a lazily populated Stream, the elements of which are the entries in the directory.
 * 2. Files.lines(Path path) that reads all lines from a file as a Stream.
 * 3. Files.find() that returns a Stream that is lazily populated with Path by searching for files in a file tree rooted 
 * at a given starting file.
 * 4. BufferedReader.lines() that return a Stream, the elements of which are lines read from this BufferedReader.
 * 
 * Miscellaneous
 * 1. ThreadLocal static method withInitial(Supplier supplier) to create instances easily.
 * 2. The Comparator interface has been extended with a lot of default and static methods for natural ordering, reverse 
 * order, etc.
 * 3. min(), max() and sum() methods in Integer, Long and Double wrapper classes.
 * 4. logicalAnd(), logicalOr() and logicalXor() methods in Boolean class.
 * 5. ZipFile.stream() method to get an ordered Stream over the ZIP file entries. Entries appear in the Stream in the 
 * order they appear in the central directory of the ZIP file.
 * 6. Several utility methods in Math class.
 * 7. jjs command is added to invoke Nashorn Engine.
 * 8. jdeps command is added to analyze class files
 * 9. JDBC-ODBC Bridge has been removed.
 * 10. PermGen memory space has been removed
 */
public class JavaIoImprovements {

}
