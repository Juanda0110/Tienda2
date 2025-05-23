package com.poligran.bugtracker.servicio;

import java.util.List;

import com.poligran.bugtracker.modelo.Bug;
import com.poligran.bugtracker.repositorio.BugRepository;

public class BugService {

    private final BugRepository repository = new BugRepository();

    public void addBug(Bug bug) {
        repository.save(bug);
    }

    public List<Bug> getBugs() {
        return repository.findAll();
    }

    public boolean updateBugStatus(int id, String newStatus) {
        return repository.updateStatus(id, newStatus);
    }

    public boolean deleteBug(int id) {
        return repository.deleteById(id);
    }

    public void clearAllBugs() {
        repository.clearAll();
    }
}
