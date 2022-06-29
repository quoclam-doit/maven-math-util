/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.quoclam.mathutil.core;

import static com.quoclam.mathutil.core.MathUtil.*;
//import stastic là dành riêng cho nh?ng hàm static
//goi hàm mà bo qua tên class

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Quoc Lam
 */
public class MathUtilTest {
///DDT , tách data ra khỏi câu lệnh kiểm thử tham số hóa data này vào trong câu lệnh kiem63m thử
    
    //chuẩn bị bộ data
    public static Object[][] initData(){
        return new Integer[][]{
                                {1, 1},
                                {1, 1},
                                {2, 2},
                                {5, 120},
                                {6, 720},
                              };
    }
    @ParameterizedTest
    @MethodSource(value = "initData")   //hàm cung cấp data ngầm định thứ tự của các phần tử của mảng và map vào tham số hàm
    public void testGetFactorialGivenRightArgumentReturnsWell(int input, long expected){
        assertEquals(expected, getFactorial(input));
        
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgumentReturnsWell(){
//        assertEquals(120, getFactorial(5));
//    }
    
    //bắt ngoại lệ khi đưa data cà chớn
//    @Test(expected = tên_ngoại_lệ.class) của junit4, junit 5 ko làm vậy
    @Test
    public void testGetFactorialGivenWrongArgumentThrowException(){
        //xài biểu thức landa
        //hàm nhận tham số th71 2 là 1 cái obj/ có code implement cái functional interface tên là Execute- có 1 hm2 duy nhất
        //tên là execute()
        //chơi chậm
//        Executable excObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };
//        assertThrows(IllegalArgumentException.class, excObject);
        Executable excObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
}
