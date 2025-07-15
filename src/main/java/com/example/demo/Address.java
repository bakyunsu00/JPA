package com.example.demo;

import jakarta.persistence.Embeddable;

    @Embeddable
    public class Address {
        private String zipCode;
        private String cityName;


        protected Address(){

        }


        public Address(String zipCode, String cityName) {
            this.zipCode = zipCode;
            this.cityName = cityName;
        }
    }



