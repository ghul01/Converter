package Main;


import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Babinszki Attila
 */
public interface ConverterInterface {

    /**
     *
     * @param input
     * @param output
     */
    public void convert(File input, File output) throws Exception;
}
