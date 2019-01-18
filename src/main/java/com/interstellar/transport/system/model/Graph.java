package com.interstellar.transport.system.model;

import java.util.List;

/*
 * Hold the data related to the link
 * 
 * */
public class Graph {
    private final List<Link> links;

    public Graph(List<Link> links) {
        this.links = links;
    }

    public List<Link> getLinks() {
        return links;
    }
}