package niituniversity.nucs.historyRecyclerView;
public class HistoryObject {
    private String rideId;
    private String time;
    public HistoryObject(String rideId, String time){
        this.rideId = rideId;
        this.time = time;
    }
    String getRideId(){return rideId;}
    String getTime(){return time;}
}