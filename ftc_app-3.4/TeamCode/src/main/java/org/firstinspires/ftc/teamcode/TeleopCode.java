package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp public class TeleopCode {





    @TeleOp(name = "Holonomic_Tele")

    public class Holonomic_Tele extends OpMode {
        private DcMotor motorFR;
        private DcMotor motorFL;
        private DcMotor motorBR;
        private DcMotor motorBL;

        public Holonomic_Tele() {

        }

        @Override
        public void init() {


            motorFR = hardwareMap.dcMotor.get("motor front right");
            motorFL = hardwareMap.dcMotor.get("motor front left");
            motorBL = hardwareMap.dcMotor.get("motor back left");
            motorBR = hardwareMap.dcMotor.get("motor back right");
        }

        @Override
        public void loop() {

            // left stick = direction
            // right stick = rotation

            float gamepad1LeftY = -gamepad1.left_stick_y;
            float gamepad1LeftX = gamepad1.left_stick_x;
            float gamepad1RightX = gamepad1.right_stick_x;

            // hhhhhhhhhh olonomicc

            float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
            float FrontLeft = gamepad1LeftY + gamepad1LeftX + gamepad1RightX;
            float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
            float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;

            motorFR.setPower(FrontRight);
            motorFL.setPower(FrontLeft);
            motorBL.setPower(BackLeft);
            motorBR.setPower(BackRight);


        }


    }
}