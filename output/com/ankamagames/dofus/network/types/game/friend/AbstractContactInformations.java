package com.ankamagames.dofus.network.types.game.friend;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AbstractContactInformations extends Object implements INetworkType {

  public int accountId = 0;
  public String accountName = "";
  public static final int protocolId = 380;

  public void serialize(ICustomDataOutput param1) {
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    param1.writeUTF(this.accountName);
  }

  public void deserialize(ICustomDataInput param1) {
    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Error(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }

    this.accountName = param1.readUTF();
  }
}
