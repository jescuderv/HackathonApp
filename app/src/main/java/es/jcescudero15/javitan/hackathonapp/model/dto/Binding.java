
package es.jcescudero15.javitan.hackathonapp.model.dto;

public class Binding {

    private Uri uri;
    private RdfsComment rdfs_comment;
    private GeoLong geo_long;
    private GeoLat geo_lat;
    private OmSeccionProcedencia om_seccionProcedencia;
    private OmHorarioEvento om_horarioEvento;
    private EventPlace event_place;
    private OmCategoriaEvento om_categoriaEvento;
    private RdfsLabel rdfs_label;
    private EventTimeIntervalStarts event_time_intervalStarts;
    private EventTimeIntervalFinishes event_time_intervalFinishes;
    private SubEvent subEvent;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public RdfsComment getRdfs_comment() {
        return rdfs_comment;
    }

    public void setRdfs_comment(RdfsComment rdfs_comment) {
        this.rdfs_comment = rdfs_comment;
    }

    public GeoLong getGeo_long() {
        return geo_long;
    }

    public void setGeo_long(GeoLong geo_long) {
        this.geo_long = geo_long;
    }

    public GeoLat getGeo_lat() {
        return geo_lat;
    }

    public void setGeo_lat(GeoLat geo_lat) {
        this.geo_lat = geo_lat;
    }

    public OmSeccionProcedencia getOm_seccionProcedencia() {
        return om_seccionProcedencia;
    }

    public void setOm_seccionProcedencia(OmSeccionProcedencia om_seccionProcedencia) {
        this.om_seccionProcedencia = om_seccionProcedencia;
    }

    public OmHorarioEvento getOm_horarioEvento() {
        return om_horarioEvento;
    }

    public void setOm_horarioEvento(OmHorarioEvento om_horarioEvento) {
        this.om_horarioEvento = om_horarioEvento;
    }

    public EventPlace getEvent_place() {
        return event_place;
    }

    public void setEvent_place(EventPlace event_place) {
        this.event_place = event_place;
    }

    public OmCategoriaEvento getOm_categoriaEvento() {
        return om_categoriaEvento;
    }

    public void setOm_categoriaEvento(OmCategoriaEvento om_categoriaEvento) {
        this.om_categoriaEvento = om_categoriaEvento;
    }

    public RdfsLabel getRdfs_label() {
        return rdfs_label;
    }

    public void setRdfs_label(RdfsLabel rdfs_label) {
        this.rdfs_label = rdfs_label;
    }

    public EventTimeIntervalStarts getEvent_time_intervalStarts() {
        return event_time_intervalStarts;
    }

    public void setEvent_time_intervalStarts(EventTimeIntervalStarts event_time_intervalStarts) {
        this.event_time_intervalStarts = event_time_intervalStarts;
    }

    public EventTimeIntervalFinishes getEvent_time_intervalFinishes() {
        return event_time_intervalFinishes;
    }

    public void setEvent_time_intervalFinishes(EventTimeIntervalFinishes event_time_intervalFinishes) {
        this.event_time_intervalFinishes = event_time_intervalFinishes;
    }

    public SubEvent getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(SubEvent subEvent) {
        this.subEvent = subEvent;
    }

}
