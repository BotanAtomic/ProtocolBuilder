package com.ankamagames.dofus.network.types.game.friend;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FriendInformations extends AbstractContactInformations implements INetworkType {

  public int playerState = 99;
  public int lastConnection = 0;
  public int achievementPoints = 0;
  public static final int protocolId = 78;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.accountId < 0) {
      throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    param1.writeUTF(this.accountName);

    param1.writeByte(this.playerState);
    if (this.lastConnection < 0) {
      throw new Exception(
          "Forbidden value (" + this.lastConnection + ") on element lastConnection.");
    }
    param1.writeVarShort(this.lastConnection);
    param1.writeInt(this.achievementPoints);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.playerState = param1.readByte();
    if (this.playerState < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.playerState
              + ") on element of FriendInformations.playerState.");
    }

    this.lastConnection = param1.readVarUhShort();
    if (this.lastConnection < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.lastConnection
              + ") on element of FriendInformations.lastConnection.");
    }

    this.achievementPoints = param1.readInt();
  }
}
