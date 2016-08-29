/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentest.controllers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ben.schellenberger
 */
public enum FirstName {

    Jacob,
    Sophia,
    Mason,
    Isabella,
    William,
    Emma,
    Jayden,
    Olivia,
    Noah,
    Ava,
    Michael,
    Emily,
    Ethan,
    Abigail,
    Alexander,
    Madison,
    Aiden,
    Mia,
    Daniel,
    Chloe,
    Anthony,
    Elizabeth,
    Matthew,
    Ella,
    Elijah,
    Addison,
    Joshua,
    Natalie,
    Liam,
    Lily,
    Andrew,
    Grace,
    James,
    Samantha,
    David,
    Avery,
    Benjamin,
    Sofia,
    Logan,
    Aubrey,
    Christopher,
    Brooklyn,
    Joseph,
    Lillian,
    Jackson,
    Victoria,
    Gabriel,
    Evelyn,
    Ryan,
    Hannah,
    Samuel,
    Alexis,
    John,
    Charlotte,
    Nathan,
    Zoey,
    Lucas,
    Leah,
    Christian,
    Amelia,
    Jonathan,
    Zoe,
    Caleb,
    Hailey,
    Dylan,
    Layla,
    Landon,
    Gabriella,
    Isaac,
    Nevaeh,
    Gavin,
    Kaylee,
    Brayden,
    Alyssa,
    Tyler,
    Anna,
    Luke,
    Sarah,
    Evan,
    Allison,
    Carter,
    Savannah,
    Nicholas,
    Ashley,
    Isaiah,
    Audrey,
    Owen,
    Taylor,
    Jack,
    Brianna,
    Jordan,
    Aaliyah,
    Brandon,
    Riley,
    Wyatt,
    Camila,
    Julian,
    Khloe,
    Aaron,
    Claire;

    public static List<String> getNames() {
        List<String> list = new ArrayList<>();
        for ( FirstName fn : values() ) {
            list.add( fn.name() );
        }
        return list;
    }

}
