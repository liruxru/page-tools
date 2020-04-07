package com.mt.tlstools.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mt.tlstools.pojo.CoalFeeder;

import java.util.List;

public interface TmcToolsService {
    List<CoalFeeder> getCoalFeeders(String loadLine);

    void startCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException;

    void stopCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException;

    void resetCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException;

    void updateFeederRunHz(CoalFeeder coalFeeder) throws JsonProcessingException;
}
