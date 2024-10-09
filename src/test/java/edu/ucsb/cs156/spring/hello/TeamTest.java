package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    // .equals testing
    Team sameTeam;
    Team difMembers;
    Team difName;
    String notTeam;

    // .hashCode testing
    Team other;


    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void equals_same_obj_returns_correct_boolean() {
        assertTrue( team.equals(team), "team.equals(team) should return True");
    }

    @Test 
    public void equals_different_class_returns_correct_boolean() {
        notTeam = "not a team object";
        assertFalse( team.equals(notTeam), "team.equals(notTeam) should return False" );
    }

    @Test
    public void equals_all_fields_returns_correct_boolean() {
        sameTeam = new Team("test-team");
        difName = new Team("test-name");
        difMembers = new Team("test-team");
        difMembers.addMember("difMember");
        assertFalse( team.equals(difName), "team.equals(difName) should return False");
        assertTrue( team.equals(sameTeam), "team.equals(sameTeam) should return True" );
        assertFalse( team.equals( difMembers), "team.equals(difMemebers) should return False");
    }
    
    @Test
    public void hashCode_returns_correct_integer() {
        other = new Team("test-team");
        team.addMember("test");
        other.addMember("test");      
        assertEquals(team.hashCode(), -1224839495);
        assertEquals(team.hashCode(), other.hashCode());
    }
}
