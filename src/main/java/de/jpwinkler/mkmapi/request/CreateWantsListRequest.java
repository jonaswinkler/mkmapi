package de.jpwinkler.mkmapi.request;

import de.jpwinkler.mkmapi.model.WantsList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class CreateWantsListRequest {

    public static class InnerObject {
        private String name;
        private int idGame;

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

    private InnerObject wantslist = new InnerObject();

    public CreateWantsListRequest(String name, int idGame) {
        wantslist.setName(name);
        wantslist.setIdGame(idGame);
    }

    public CreateWantsListRequest() {
    }

    public InnerObject getWantslist() {
        return wantslist;
    }

    public void setWantslist(InnerObject wantslist) {
        this.wantslist = wantslist;
    }
}
