package com.example.pc.viewpager.Models;

/**
 * Created by pc on 26/04/2018.
 */


    import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Team {

        //@SerializedName("_links")
        //@Expose
       // private Links_ links;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("code")
        @Expose
        private Object code;
        @SerializedName("shortName")
        @Expose
        private String shortName;
        @SerializedName("squadMarketValue")
        @Expose
        private Object squadMarketValue;
        @SerializedName("crestUrl")
        @Expose
        private Object crestUrl;

       /* public Links_ getLinks() {
            return links;
        }

        public void setLinks(Links_ links) {
            this.links = links;
        }*/

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public Object getSquadMarketValue() {
            return squadMarketValue;
        }

        public void setSquadMarketValue(Object squadMarketValue) {
            this.squadMarketValue = squadMarketValue;
        }

        public Object getCrestUrl() {
            return crestUrl;
        }

        public void setCrestUrl(Object crestUrl) {
            this.crestUrl = crestUrl;
        }

    }

