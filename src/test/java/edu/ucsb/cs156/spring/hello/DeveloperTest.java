package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Michael J", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void getGithubID_returns_correct_githubID() {
        assertEquals("michaelljiang", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name(){
        Team t = Developer.getTeam();
        assertEquals("f24-06", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Michael J"),"Team should contain Michael J");
        assertTrue(t.getMembers().contains("Christopher L"),"Team should contain Christopher L");
        assertTrue(t.getMembers().contains("Edward"),"Team should contain Edward");
        assertTrue(t.getMembers().contains("Victor"),"Team should contain Victor");
        assertTrue(t.getMembers().contains("Skanda"),"Team should contain Skanda");
        assertTrue(t.getMembers().contains("Xinghan"),"Team should contain Xinghan");
    }
    
    // cmds for viewing test reports :

    // mvn test jacoco:report
    // open target/site/jacoco/index.html

    // mvn pitest:mutationCoveage
    // open target/pit-reports/index.html
}
