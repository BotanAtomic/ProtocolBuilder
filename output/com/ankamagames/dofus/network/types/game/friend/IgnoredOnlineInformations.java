package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;
import java.lang.Exception;

public class IgnoredOnlineInformations extends IgnoredInformations implements INetworkType {

    private int protocolId = 105;
    private Number playerId = 0;
    private String playerName = "";
    private int breed = 0;
    private boolean sex = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_IgnoredInformations(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeUTF(this.playerName);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
    }

    public void deserialize(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of AbstractContactInformations.accountId.");
         }
         this.accountName = param1.readUTF();
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of IgnoredOnlineInformations.playerId.");
         }
         this.playerName = param1.readUTF();
         this.breed = param1.readByte();
         if(this.breed < PlayableBreedEnum.Feca || this.breed > PlayableBreedEnum.Ouginak)
         {
            throw new Exception("Forbidden value (" + this.breed + ") on element of IgnoredOnlineInformations.breed.");
         }
         this.sex = param1.readBoolean();
    }

}