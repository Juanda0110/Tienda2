package com.poligran.bugtracker.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.poligran.bugtracker.modelo.Bug;

public class BugRepository {
    private List<Bug> bugs = new ArrayList<>();

    public void save(Bug bug) {
        bugs.add(bug);
    }

    public List<Bug> findAll() {
        return bugs;
    }

    public boolean updateStatus(int id, String newStatus) {
        for (Bug bug : bugs) {
            if (bug.getId() == id) {
                bug.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(int id) {
        return bugs.removeIf(bug -> bug.getId() == id);
    }

    public void clearAll() {
        bugs.clear();
    }
}
