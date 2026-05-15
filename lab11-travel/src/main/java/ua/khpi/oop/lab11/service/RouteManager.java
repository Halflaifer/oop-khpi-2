package ua.khpi.oop.lab11.service;

import ua.khpi.oop.lab11.model.TripStop;
import java.util.*;

public class RouteManager {
    private final List<TripStop> routeSequence = new ArrayList<>();
    

    private final Map<String, TripStop> stopsMap = new HashMap<>();
    

    private final Set<String> uniqueCities = new HashSet<>();

    public void addStop(TripStop stop) {
        if (stopsMap.containsKey(stop.getStopId())) {
            throw new IllegalArgumentException("Зупинка з ID " + stop.getStopId() + " вже існує!");
        }
        routeSequence.add(stop);               
        stopsMap.put(stop.getStopId(), stop);   
        uniqueCities.add(stop.getCityName());   
    }

    public TripStop findById(String id) {
        return stopsMap.get(id); 
    }

    public List<TripStop> getFullRoute() {
        return Collections.unmodifiableList(routeSequence); 
    }

    public Set<String> getCities() {
        return Collections.unmodifiableSet(uniqueCities); 
    }

    public boolean removeStop(String id) {
        TripStop stop = stopsMap.remove(id); 
        if (stop != null) {
            routeSequence.remove(stop); 
            return true;
        }
        return false;
    }
}