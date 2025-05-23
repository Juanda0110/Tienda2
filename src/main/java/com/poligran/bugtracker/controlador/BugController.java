package com.poligran.bugtracker.controlador;

import java.util.List;

import com.poligran.bugtracker.modelo.Bug;
import com.poligran.bugtracker.servicio.BugService;

public class BugController {

    private final BugService service = new BugService();

    public void createBug(Bug bug) {
        service.addBug(bug);
    }

    public List<Bug> listBugs() {
        return service.getBugs();
    }

    public boolean changeBugStatus(int id, String newStatus) {
        return service.updateBugStatus(id, newStatus);
    }

    public boolean removeBug(int id) {
        return service.deleteBug(id);
    }

    public void clearAllBugs() {
        service.clearAllBugs();
    }
}
