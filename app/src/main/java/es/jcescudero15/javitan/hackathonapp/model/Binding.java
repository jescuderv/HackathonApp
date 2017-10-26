
package es.jcescudero15.javitan.hackathonapp.model;

public class Binding {

    private Uri uri;
    private RdfsComment rdfsComment;
    private GeoLong geoLong;
    private GeoLat geoLat;
    private OmSeccionProcedencia omSeccionProcedencia;
    private OmHorarioEvento omHorarioEvento;
    private EventPlace eventPlace;
    private OmCategoriaEvento omCategoriaEvento;
    private RdfsLabel rdfsLabel;
    private EventTimeIntervalStarts eventTimeIntervalStarts;
    private EventTimeIntervalFinishes eventTimeIntervalFinishes;
    private SubEvent subEvent;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public RdfsComment getRdfsComment() {
        return rdfsComment;
    }

    public void setRdfsComment(RdfsComment rdfsComment) {
        this.rdfsComment = rdfsComment;
    }

    public GeoLong getGeoLong() {
        return geoLong;
    }

    public void setGeoLong(GeoLong geoLong) {
        this.geoLong = geoLong;
    }

    public GeoLat getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(GeoLat geoLat) {
        this.geoLat = geoLat;
    }

    public OmSeccionProcedencia getOmSeccionProcedencia() {
        return omSeccionProcedencia;
    }

    public void setOmSeccionProcedencia(OmSeccionProcedencia omSeccionProcedencia) {
        this.omSeccionProcedencia = omSeccionProcedencia;
    }

    public OmHorarioEvento getOmHorarioEvento() {
        return omHorarioEvento;
    }

    public void setOmHorarioEvento(OmHorarioEvento omHorarioEvento) {
        this.omHorarioEvento = omHorarioEvento;
    }

    public EventPlace getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(EventPlace eventPlace) {
        this.eventPlace = eventPlace;
    }

    public OmCategoriaEvento getOmCategoriaEvento() {
        return omCategoriaEvento;
    }

    public void setOmCategoriaEvento(OmCategoriaEvento omCategoriaEvento) {
        this.omCategoriaEvento = omCategoriaEvento;
    }

    public RdfsLabel getRdfsLabel() {
        return rdfsLabel;
    }

    public void setRdfsLabel(RdfsLabel rdfsLabel) {
        this.rdfsLabel = rdfsLabel;
    }

    public EventTimeIntervalStarts getEventTimeIntervalStarts() {
        return eventTimeIntervalStarts;
    }

    public void setEventTimeIntervalStarts(EventTimeIntervalStarts eventTimeIntervalStarts) {
        this.eventTimeIntervalStarts = eventTimeIntervalStarts;
    }

    public EventTimeIntervalFinishes getEventTimeIntervalFinishes() {
        return eventTimeIntervalFinishes;
    }

    public void setEventTimeIntervalFinishes(EventTimeIntervalFinishes eventTimeIntervalFinishes) {
        this.eventTimeIntervalFinishes = eventTimeIntervalFinishes;
    }

    public SubEvent getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(SubEvent subEvent) {
        this.subEvent = subEvent;
    }

}
