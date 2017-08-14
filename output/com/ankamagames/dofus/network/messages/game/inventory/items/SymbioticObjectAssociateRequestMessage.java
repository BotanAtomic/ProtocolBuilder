package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SymbioticObjectAssociateRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int symbioteUID = 0;
  public int symbiotePos = 0;
  public int hostUID = 0;
  public int hostPos = 0;
  public static final int protocolId = 6522;

  public void serialize(ICustomDataOutput param1) {
    if (this.symbioteUID < 0) {
      throw new Error("Forbidden value (" + this.symbioteUID + ") on element symbioteUID.");
    }
    param1.writeVarInt(this.symbioteUID);
    if (this.symbiotePos < 0 || this.symbiotePos > 255) {
      throw new Error("Forbidden value (" + this.symbiotePos + ") on element symbiotePos.");
    }
    param1.writeByte(this.symbiotePos);
    if (this.hostUID < 0) {
      throw new Error("Forbidden value (" + this.hostUID + ") on element hostUID.");
    }
    param1.writeVarInt(this.hostUID);
    if (this.hostPos < 0 || this.hostPos > 255) {
      throw new Error("Forbidden value (" + this.hostPos + ") on element hostPos.");
    }
    param1.writeByte(this.hostPos);
  }

  public void deserialize(ICustomDataInput param1) {
    this.symbioteUID = param1.readVarUhInt();
    if (this.symbioteUID < 0) {
      throw new Error(
          "Forbidden value ("
              + this.symbioteUID
              + ") on element of SymbioticObjectAssociateRequestMessage.symbioteUID.");
    }

    this.symbiotePos = param1.readUnsignedByte();
    if (this.symbiotePos < 0 || this.symbiotePos > 255) {
      throw new Error(
          "Forbidden value ("
              + this.symbiotePos
              + ") on element of SymbioticObjectAssociateRequestMessage.symbiotePos.");
    }

    this.hostUID = param1.readVarUhInt();
    if (this.hostUID < 0) {
      throw new Error(
          "Forbidden value ("
              + this.hostUID
              + ") on element of WrapperObjectDissociateRequestMessage.hostUID.");
    }

    this.hostPos = param1.readUnsignedByte();
    if (this.hostPos < 0 || this.hostPos > 255) {
      throw new Error(
          "Forbidden value ("
              + this.hostPos
              + ") on element of WrapperObjectDissociateRequestMessage.hostPos.");
    }
  }
}
