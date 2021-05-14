package ru.job4j.generics;

public class RoleStore implements Store<Role> {

    private final Store<Role> rol = new MemStore<>();

    @Override
    public void add(Role model) {
        rol.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return rol.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return rol.delete(id);
    }

    @Override
    public Role findById(String id) {
        return rol.findById(id);
    }
}
