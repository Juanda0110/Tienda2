package com.poligran.bugtracker.servicio;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.poligran.bugtracker.modelo.Bug;

public class BugServiceTest {

    private BugService bugService;

    @BeforeEach
    public void setUp() {
        bugService = new BugService();
    }

    @Test
    public void testAddBug() {
        Bug bug = new Bug(1, "Error login", "No permite ingresar", "Alta", "Pendiente");
        bugService.addBug(bug);
        List<Bug> bugs = bugService.getBugs();
        assertEquals(1, bugs.size());
    }
}