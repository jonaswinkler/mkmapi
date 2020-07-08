package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.WantsList;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class WantsListResponse {

    public static class FailedInnerObject {
        private String error;
        private String name;
        private int idGame;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIdGame() {
            return idGame;
        }

        public void setIdGame(int idGame) {
            this.idGame = idGame;
        }
    }

    private List<WantsList> wantslist = new ArrayList<>();

    private FailedInnerObject failed;

    public List<WantsList> getWantslist() {
        return wantslist;
    }

    public void setWantslist(List<WantsList> wantslist) {
        this.wantslist = wantslist;
    }

    public FailedInnerObject getFailed() {
        return failed;
    }

    public void setFailed(FailedInnerObject failed) {
        this.failed = failed;
    }
}
