package com.ankamagames.dofus.network.messages.game.atlas.compass;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.MapCoordinates;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CompassUpdatePvpSeekMessage extends CompassUpdateMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number memberId = 0;
  public String memberName = "";
  public static final int protocolId = 6013;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.type);
    param1.writeShort(this.coords.getTypeId());
    this.coords.serialize(param1);

    if (this.memberId < 0 || this.memberId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.memberId + ") on element memberId.");
    }
    param1.writeVarLong(this.memberId);
    param1.writeUTF(this.memberName);
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

    this.memberId = param1.readInt();
    if (this.memberId < 0) {
      throw new Error(
          "Forbidden value (" + this.memberId + ") on element of PartyMemberGeoPosition.memberId.");
    }

    this.memberName = param1.readUTF();
  }
}
