package com.diycomputerscience.example.sanddi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoardTest.class, FilePersistenceStrategyTest.class })
public class AllTests {

}
