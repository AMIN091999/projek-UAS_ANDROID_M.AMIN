<?php
  $server = "localhost";
   $username = "root";
   $password = "";
   $database = "db_kontak";

   $konek = mysqli_connect($server,$username,$password,$database);

   if (mysqli_connect_error()) {
      echo "Gagal konek dengan Database" . mysqli_connect_error();
   }

 if($_SERVER['REQUEST_METHOD']=='POST')
{
   $id=$_POST['id'];
   $nm_kontak=$_POST['nm_kontak'];
   $no_kontak=$_POST['no_kontak'];

   $query="INSERT INTO tb_kontak(nm_kontak,no_kontak) VALUES('$nm_kontak','$no_kontak')";
   $exeQuery=mysqli_query($konek,$query);

   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'Input Kontak Success'

      )
   ):json_encode(array('kode'=>2,'pesan'=>'Input Kontak Gagal'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}

?>