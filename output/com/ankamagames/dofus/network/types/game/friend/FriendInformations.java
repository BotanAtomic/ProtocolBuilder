package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FriendInformations extends AbstractContactInformations implements INetworkType {

    private int protocolId = 78;
    private int playerState = 99;
    private int lastConnection = 0;
    private int achievementPoints = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         param1.writeUTF(this.accountName);
         param1.writeByte(this.playerState);
         if(this.lastConnection < 0)
         {
            throw new Exception("Forbidden value (" + this.lastConnection + ") on element lastConnection.");
         }
         param1.writeVarShort(this.lastConnection);
         param1.writeInt(this.achievementPoints);
    }

    public void deserialize(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of AbstractContactInformations.accountId.");
         }
         this.accountName = param1.readUTF();
         this.playerState = param1.readByte();
         if(this.playerState < 0)
         {
            throw new Exception("Forbidden value (" + this.playerState + ") on element of FriendInformations.playerState.");
         }
         this.lastConnection = param1.readVarUhShort();
         if(this.lastConnection < 0)
         {
            throw new Exception("Forbidden value (" + this.lastConnection + ") on element of FriendInformations.lastConnection.");
         }
         this.achievementPoints = param1.readInt();
    }

}