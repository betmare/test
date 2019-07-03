package amazonTest;

import java.util.*;

public class ShippingFlight {
    static List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        TreeMap<Integer, Integer> forwardRoute = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> returnRoute = new TreeMap<>(Collections.reverseOrder());
        for (List<Integer> forward: forwardRouteList) {
            forwardRoute.put(forward.get(0), forward.get(1));
        }
        for (List<Integer> returnTravel: returnRouteList) {
            returnRoute.put(returnTravel.get(0), returnTravel.get(1));
        }
        int maxPossible = Integer.MIN_VALUE;
        List<List<Integer>> shippingRoutes = new ArrayList<>();
        Map<List<Integer>,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,Integer> forwardR : forwardRoute.entrySet()) {
            for(Map.Entry<Integer, Integer> returnR : returnRoute.entrySet()) {
                int travelDist = forwardR.getValue()+returnR.getValue();
                if(travelDist<=maxTravelDist) {
                    if(travelDist>=maxPossible) {
                        maxPossible=travelDist;
                        List<Integer> list = new ArrayList<>();
                        list.add(forwardR.getKey());
                        list.add(returnR.getKey());
                        map.put(list, travelDist);
                    }
                }
            }
        }
        for(Map.Entry<List<Integer>, Integer> max: map.entrySet()) {
            if(max.getValue()==maxPossible) {
                List<Integer> routes = new ArrayList<>();
                routes.addAll(max.getKey());
                shippingRoutes.add(routes);
            }
        }

        return shippingRoutes;
    }
    public static void main(String[] args) {
        int maxTravelDist = 20;
        List<List<Integer>> forwardRouteList = new ArrayList<>();
        List<Integer> first= new ArrayList<>();
        first.add(1);
        first.add(8);
        forwardRouteList.add(first);
        List<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(7);
        forwardRouteList.add(second);
        List<Integer> third = new ArrayList<>();
        third.add(3);
        third.add(14);
        forwardRouteList.add(third);

        List<List<Integer>> returnRouteList = new ArrayList<>();
        List<Integer> firstReturn= new ArrayList<>();
        firstReturn.add(1);
        firstReturn.add(6);
        returnRouteList.add(firstReturn);
        List<Integer> secondReturn = new ArrayList<>();
        secondReturn.add(2);
        secondReturn.add(13);
        returnRouteList.add(secondReturn);
        List<Integer> thirdReturn = new ArrayList<>();
        thirdReturn.add(3);
        thirdReturn.add(14);
        returnRouteList.add(thirdReturn);

        System.out.println(optimalUtilization(maxTravelDist,forwardRouteList,returnRouteList));

    }
}
