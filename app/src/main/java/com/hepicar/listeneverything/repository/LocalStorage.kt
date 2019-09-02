package com.hepicar.listeneverything.repository

import android.os.Environment
import com.hepicar.listeneverything.model.HeartRate
import com.hepicar.listeneverything.model.NBack
import com.hepicar.listeneverything.model.TMT
import java.io.File
import java.io.FileWriter
import java.io.IOException

class LocalStorage{
    companion object {
        fun saveToCsv(data:List<HeartRate>){
            val CSV_HEADER = "timestamp,ir,red"
            var fileWriter: FileWriter? = null
            val fielName : String = System.currentTimeMillis().toString()+"_heart_rate.csv"
            try {
                var f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                var file = File(f,fielName)
                println("file is exist "+file.exists())
                fileWriter = FileWriter(file)

                fileWriter.append(CSV_HEADER)
                fileWriter.append('\n')

                for (item in data) {
                    fileWriter.append(item.timestampString.toString())
                    fileWriter.append(',')
                    fileWriter.append(item.hrm_ir.toString())
                    fileWriter.append(',')
                    fileWriter.append(item.hrm_red.toString())
                    fileWriter.append('\n')
                }

                println("Write CSV successfully!")
            } catch (e: Exception) {
                println("Writing CSV error!")
                e.printStackTrace()
            } finally {
                try {
                    fileWriter!!.flush()
                    fileWriter.close()
                } catch (e: IOException) {
                    println("Flushing/closing error!")
                    e.printStackTrace()
                }
            }
        }

        fun saveToCSVTMT(data:List<TMT>, code:String, nama:String){
            val CSV_HEADER = "timestamp,value"
            var fileWriter: FileWriter? = null
            val fielName : String = nama+"_"+System.currentTimeMillis().toString()+"_tmt_"+code+".csv"
            try {
                var f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                var file = File(f,fielName)
                println("file is exist "+file.exists())
                fileWriter = FileWriter(file)

                fileWriter.append(CSV_HEADER)
                fileWriter.append('\n')

                for (item in data) {
                    fileWriter.append(item.timestampString.toString())
                    fileWriter.append(',')
                    fileWriter.append(item.value.toString())
                    fileWriter.append('\n')
                }

                println("Write CSV successfully!")
            } catch (e: Exception) {
                println("Writing CSV error!")
                e.printStackTrace()
            } finally {
                try {
                    fileWriter!!.flush()
                    fileWriter.close()
                } catch (e: IOException) {
                    println("Flushing/closing error!")
                    e.printStackTrace()
                }
            }
        }

        fun saveToCSVNBack(data:List<NBack>, code: String, nama: String){
            val CSV_HEADER = "timestamp,value"
            var fileWriter: FileWriter? = null
            val fielName : String = nama+"_"+System.currentTimeMillis().toString()+"_nback_"+code+".csv"
            try {
                var f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                var file = File(f,fielName)
                println("file is exist "+file.exists())
                fileWriter = FileWriter(file)

                fileWriter.append(CSV_HEADER)
                fileWriter.append('\n')

                for (item in data) {
                    fileWriter.append(item.timestampString.toString())
                    fileWriter.append(',')
                    fileWriter.append(item.value.toString())
                    fileWriter.append('\n')
                }

                println("Write CSV successfully!")
            } catch (e: Exception) {
                println("Writing CSV error!")
                e.printStackTrace()
            } finally {
                try {
                    fileWriter!!.flush()
                    fileWriter.close()
                } catch (e: IOException) {
                    println("Flushing/closing error!")
                    e.printStackTrace()
                }
            }
        }
    }
}