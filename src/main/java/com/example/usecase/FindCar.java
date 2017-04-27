/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.usecase;

import java.util.Optional;

import com.example.annotation.UseCase;
import com.example.domain.Car;
import com.example.external.data.CarEntity;
import com.example.external.data.CarRepository;

import lombok.SneakyThrows;

/**
 *  
 */
@UseCase
public class FindCar {

    private final CarRepository carRepository;

    public FindCar(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @SneakyThrows
    public Optional<Car> findCar(String name) {

        CarEntity carEntity = carRepository.findByName(name);

        if (carEntity != null) {
            return Optional.ofNullable(new Car(carEntity.getName()));
        }

        return Optional.empty();
    }
}
