package br.com.erudio;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({ MethodOrderedByName.class, MethodOrderedByOrderIndexTest.class, MethodOrderedRandomlyTest.class })
public class MethodOrderedTests {

}
