package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MimicryObjectFeedAndAssociateRequestMessage
    extends SymbioticObjectAssociateRequestMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int foodUID = 0;
  public int foodPos = 0;
  public boolean preview = false;
  public static final int protocolId = 6460;

  @Override
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

    if (this.foodUID < 0) {
      throw new Error("Forbidden value (" + this.foodUID + ") on element foodUID.");
    }
    param1.writeVarInt(this.foodUID);
    if (this.foodPos < 0 || this.foodPos > 255) {
      throw new Error("Forbidden value (" + this.foodPos + ") on element foodPos.");
    }
    param1.writeByte(this.foodPos);
    param1.writeBoolean(this.preview);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.foodUID = param1.readVarUhInt();
    if (this.foodUID < 0) {
      throw new Error(
          "Forbidden value (" + this.foodUID + ") on element of ObjectFeedMessage.foodUID.");
    }

    this.foodPos = param1.readUnsignedByte();
    if (this.foodPos < 0 || this.foodPos > 255) {
      throw new Error(
          "Forbidden value ("
              + this.foodPos
              + ") on element of MimicryObjectFeedAndAssociateRequestMessage.foodPos.");
    }

    this.preview = param1.readBoolean();
  }
}
