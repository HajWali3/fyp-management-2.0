"use client";
import React from "react";
import Link from "next/link";
import { Meteors } from "@/components/ui/meteors";

export default function AdminDashboard() {
  const totalStudents = 120;
  const totalSupervisors = 15;
  const totalProjects = 40;
  const unassignedProposals = 7;

  return (
    <div className="">
      <div className="grid grid-cols-1  lg:grid-cols-2 gap-5   pt-36 justify-items-center">
        {/* Card 1 */}
        <div className="flex justify-center">
          <div className="relative w-full max-w-xl">
            <div className="absolute inset-0 h-full w-full scale-[0.80] transform rounded-full bg-red-500 bg-gradient-to-r from-blue-500 to-teal-500 blur-3xl" />
            <div className="relative w-80 sm:w-96 flex h-full flex-col items-start justify-end overflow-hidden rounded-2xl border border-gray-800 bg-gray-900 px-4 py-8 shadow-xl">
              <div className="mb-4 flex h-5 w-5 items-center justify-center rounded-full border border-gray-500">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth="1.5"
                  stroke="currentColor"
                  className="h-2 w-2 text-gray-300"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M4.5 4.5l15 15m0 0V8.25m0 11.25H8.25"
                  />
                </svg>
              </div>

              <h1 className="relative z-50 mb-4 text-xl font-bold text-white">
                Total Students
              </h1>

              <p className="relative z-50 mb-4 text-base font-normal text-slate-500">
                {totalStudents}
              </p>

              <Link href="student/submit-proposal">
                <button className="rounded-lg border border-gray-500 px-4 py-1 text-gray-300">
                  Manage Students
                </button>
              </Link>

              {/* Meaty part - Meteor effect */}
              <Meteors number={20} />
            </div>
          </div>
        </div>

        {/* Card 2 */}
        <div className="flex justify-center">
          <div className="relative w-full max-w-xl">
            <div className="absolute inset-0 h-full w-full scale-[0.80] transform rounded-full bg-red-500 bg-gradient-to-r from-blue-500 to-teal-500 blur-3xl" />
            <div className="relative w-80 sm:w-96 flex h-full flex-col items-start justify-end overflow-hidden rounded-2xl border border-gray-800 bg-gray-900 px-4 py-8 shadow-xl">
              <div className="mb-4 flex h-5 w-5 items-center justify-center rounded-full border border-gray-500">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth="1.5"
                  stroke="currentColor"
                  className="h-2 w-2 text-gray-300"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M4.5 4.5l15 15m0 0V8.25m0 11.25H8.25"
                  />
                </svg>
              </div>

              <h1 className="relative z-50 mb-4 text-xl font-bold text-white">
                Total Supervisors
              </h1>

              <p className="relative z-50 mb-4 text-base font-normal text-slate-500">
                {totalSupervisors}
              </p>

              <Link
                href="/admin/supervisors"
                className="text-indigo-600 hover:underline mt-2 inline-block"
              >
                <button className="rounded-lg border border-gray-500 px-4 py-1 text-gray-300">
                  Manage Supervisors
                </button>
              </Link>

              {/* Meaty part - Meteor effect */}
              <Meteors number={20} />
            </div>
          </div>
        </div>

        {/* Card 3 */}
        <div className="flex justify-center">
          <div className="relative w-full max-w-xl">
            <div className="absolute inset-0 h-full w-full scale-[0.80] transform rounded-full bg-red-500 bg-gradient-to-r from-blue-500 to-teal-500 blur-3xl" />
            <div className="relative w-80 sm:w-96 flex h-full flex-col items-start justify-end overflow-hidden rounded-2xl border border-gray-800 bg-gray-900 px-4 py-8 shadow-xl">
              <div className="mb-4 flex h-5 w-5 items-center justify-center rounded-full border border-gray-500">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth="1.5"
                  stroke="currentColor"
                  className="h-2 w-2 text-gray-300"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M4.5 4.5l15 15m0 0V8.25m0 11.25H8.25"
                  />
                </svg>
              </div>

              <h1 className="relative z-50 mb-4 text-xl font-bold text-white">
                Total Projects
              </h1>

              <p className="relative z-50 mb-4 text-base font-normal text-slate-500">
                {totalProjects}
              </p>

              <Link href="student/submission">
                <button className="rounded-lg border border-gray-500 px-4 py-1 text-gray-300">
                  View Projects
                </button>
              </Link>

              {/* Meaty part - Meteor effect */}
              <Meteors number={20} />
            </div>
          </div>
        </div>

        {/* Card 4 */}
        <div className="flex justify-center">
          <div className="relative w-full max-w-xl">
            <div className="absolute inset-0 h-full w-full scale-[0.80] transform rounded-full bg-red-500 bg-gradient-to-r from-blue-500 to-teal-500 blur-3xl" />
            <div className="relative w-80 sm:w-96 flex h-full flex-col items-start justify-end overflow-hidden rounded-2xl border border-gray-800 bg-gray-900 px-4 py-8 shadow-xl">
              <div className="mb-4 flex h-5 w-5 items-center justify-center rounded-full border border-gray-500">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth="1.5"
                  stroke="currentColor"
                  className="h-2 w-2 text-gray-300"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M4.5 4.5l15 15m0 0V8.25m0 11.25H8.25"
                  />
                </svg>
              </div>

              <h1 className="relative z-50 mb-4 text-xl font-bold text-white">
                Unassigned Proposals
              </h1>

              <p className="relative z-50 mb-4 text-base font-normal text-slate-500">
                {unassignedProposals}
              </p>

              <Link href="/feedback/${projectId"></Link>
              <button className="rounded-lg border border-gray-500 px-4 py-1 text-gray-300">
                Assign Now
              </button>

              {/* Meaty part - Meteor effect */}
              <Meteors number={20} />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

// return (
//   <div className="min-h-screen bg-slate-50 p-6">
//     <div className="max-w-5xl mx-auto">
//       <h1 className="text-4xl font-bold mb-6 text-slate-800">
//         Welcome, Admin 🛠️
//       </h1>

//       <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-3">
//         {/* Total Students */}
//         <div className="bg-white rounded-2xl shadow-md p-6 border border-slate-200">
//           <h2 className="text-2xl font-semibold text-slate-700 mb-2">
//             Total Students
//           </h2>
//           <p className="text-lg text-slate-800">{totalStudents}</p>
//           <Link
//             href="/admin/students"
//             className="text-indigo-600 hover:underline mt-2 inline-block"
//           >
//             Manage Students
//           </Link>
//         </div>

//         {/* Total Supervisors */}
//         <div className="bg-white rounded-2xl shadow-md p-6 border border-slate-200">
//           <h2 className="text-2xl font-semibold text-slate-700 mb-2">
//             Total Supervisors
//           </h2>
//           <p className="text-lg text-slate-800">{totalSupervisors}</p>
//           <Link
//             href="/admin/supervisors"
//             className="text-indigo-600 hover:underline mt-2 inline-block"
//           >
//             Manage Supervisors
//           </Link>
//         </div>

//         {/* Total Projects */}
//         <div className="bg-white rounded-2xl shadow-md p-6 border border-slate-200">
//           <h2 className="text-2xl font-semibold text-slate-700 mb-2">
//             Total Projects
//           </h2>
//           <p className="text-lg text-slate-800">{totalProjects}</p>
//           <Link
//             href="/admin/projects"
//             className="text-indigo-600 hover:underline mt-2 inline-block"
//           >
//             View Projects
//           </Link>
//         </div>

//         {/* Unassigned Proposals */}
//         <div className="bg-white rounded-2xl shadow-md p-6 border border-slate-200">
//           <h2 className="text-2xl font-semibold text-slate-700 mb-2">
//             Unassigned Proposals
//           </h2>
//           <p className="text-lg text-rose-600">{unassignedProposals}</p>
//           <Link
//             href="/admin/assign-proposals"
//             className="text-indigo-600 hover:underline mt-2 inline-block"
//           >
//             Assign Now
//           </Link>
//         </div>
//       </div>
//     </div>
//   </div>
// );
