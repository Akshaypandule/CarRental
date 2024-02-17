package com.CarRental.service.ServiceImpl;

import com.CarRental.dto.HotelDto;
import com.CarRental.entity.Hotel;
import com.CarRental.repo.HotelRepository;
import com.CarRental.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public HotelDto addHotel(HotelDto hotelDto)
    {
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        Hotel save = hotelRepository.save(hotel);
        return modelMapper.map(save,HotelDto.class);
    }
    public List<HotelDto> getAllHotel()
    {
        List<Hotel> all = hotelRepository.findAll();
        List<HotelDto> collect =
                all.stream().map(hotel -> modelMapper.map(hotel, HotelDto.class))
                        .collect(Collectors.toList());

        return collect;

    }
}
