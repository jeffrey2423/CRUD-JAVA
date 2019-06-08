/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  STH_1F_MCA_PC27
 * Created: 8/06/2019
 */

CREATE DATABASE tienda;

USE tienda;

CREATE TABLE(
id INT(11) AUTO_INCREMENT,
codigo VARCHAR(20) NOT NULL,
nombre VARCHAR(20) NOT NULL,
precio DECIMAL(10,2) NOT NULL,
cantidad INT(11) NOT NULL,
PRYMARY KEY (id)
);
