package solution.epam;

import solution.epam.filters.impl.ElevatedRolesFilter;
import solution.epam.filters.impl.ElevatedRolesOnAccessLevelFilter;
import solution.epam.filters.impl.RolesAboveAccessLevelFilter;
import solution.epam.filters.impl.RolesBelowAccessLevelFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//am i breaking the law of demeter in the examples below ?
public class RoleManager {

    public Set<Role> getElevatedRoles() {
        return new HashSet<>(Arrays.asList(Role.values())).stream().filter(role -> new ElevatedRolesFilter().elevate(role)).collect(Collectors.toSet());
    }

    public Set<Role> getRolesAboveAccessLevel(int accessLevel) {
        return new HashSet<>(Arrays.asList(Role.values())).stream().filter(role -> new RolesAboveAccessLevelFilter().elevate(role, accessLevel)).collect(Collectors.toSet());
    }

    public Set<Role> getRolesBelowAccessLevel(int accessLevel) {
        return new HashSet<>(Arrays.asList(Role.values())).stream().filter(role -> new RolesBelowAccessLevelFilter().elevate(role, accessLevel)).collect(Collectors.toSet());

    }

    public Set<Role> getElevatedRolesOnAccessLevel(int accessLevel) {
        return new HashSet<>(Arrays.asList(Role.values())).stream().filter(role -> new ElevatedRolesOnAccessLevelFilter().elevate(role, accessLevel)).collect(Collectors.toSet());
    }
}
