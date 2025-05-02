import mongoose, { Schema } from "mongoose";

const proposalSchema = new Schema({
  title: String,
  description: String,
  domain: String,
  tools: String,
  status: {
    type: String,
    default: "Pending", // or 'Approved', 'Rejected'
  },
  feedback: {
    type: String,
    default: "",
  },
  student: {
    type: mongoose.Schema.Types.ObjectId,
    ref: "User",
  },
  supervisor: {
    type: mongoose.Schema.Types.ObjectId,
    ref: "User",
    default: null,
  },
});

export const Proposal = mongoose.model("Proposal", proposalSchema);
