"use client";
import React, { useEffect, useState } from "react";
import axios from "axios";
import toast, { Toast } from "react-hot-toast";
import { useRouter } from "next/navigation";
import Link from "next/link";
import { div } from "motion/react-client";

export default function ProfilePage() {
  const router = useRouter();
  const [username, setUsername] = useState("nothing");
  const [email, setEmail] = useState("nothing");
  const [role, setRole] = useState("nothing");
  const [id, setId] = useState("nothing");
  const [data, setData] = useState({});

  const getUserDetails = async () => {
    try {
      const res = await axios.post("/api/users/aboutme");
      const userData = res.data.data;

      console.log(userData);

      setId(userData._id);
      setUsername(userData.username);
      setEmail(userData.email);
      setRole(userData.role);
      setData(userData); // optional if you still want to use `data`
    } catch (error: any) {
      console.log(error.message);
      toast.error(error.message);
    }
  };

  useEffect(() => {
    getUserDetails();
  }, []);

  const logout = async () => {
    try {
      await axios.post("/api/users/logout");
      toast.success("User logout succesfully");
      router.push("/login");
    } catch (error: any) {
      console.log(error.message);
      toast.error(error.message);
    }
  };
  return (
    <div className="flex flex-col items-center justify-center min-h-screen py-2 ">
      <h1>profile page</h1>
      <hr />
      <h2>
        {" "}
        {id === "nothing" ? (
          "nothing"
        ) : (
          <Link href={`/profile/${id}`}>{id}</Link>
        )}{" "}
      </h2>
      <hr />

      <div>
        {id && (
          <div>
            <h2>Name: {username}</h2>
            <h2>Email: {email}</h2>
            <h2>Role: {role}</h2>
          </div>
        )}
      </div>

      <button
        className="bg-blue-500 p-2 border border-gray-300 rounded-lg mb-4 focus:outline-none focus:border-gray-600 "
        onClick={logout}
      >
        logout
      </button>
    </div>
  );
}
