<?php
 $server = "localhost";
   $username = "root";
   $password = "";
   $database = "db_kontak";

   $konek = mysqli_connect($server,$username,$password,$database);

   if (mysqli_connect_error()) {
      echo "Gagal konek dengan Database" . mysqli_connect_error();
   }

 if($_SERVER['REQUEST_METHOD'])
{
   $id=$_POST['id'];
   $nm_kontak=$_POST['nm_kontak'];
   $no_kontak=$_POST['no_kontak'];

   $query="UPDATE tb_kontak SET nm_kontak='$nm_kontak',no_kontak='$no_kontak' WHERE id='$id'";
   
   $exeQuery=mysqli_query($konek,$query);
   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'Update Kontak Berhasil'
   	)
   ):json_encode(array('kode'=>2,'pesan'=>'Update Kontak Gagal'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak nya gk valid'));
}

header('Content-Type: application/json');
?>
                     