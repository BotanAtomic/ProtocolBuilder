package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;
import java.lang.Exception;

public class DungeonPartyFinderPlayer extends Object implements INetworkType {

    private int protocolId = 373;
    private Number playerId = 0;
    private String playerName = "";
    private int breed = 0;
    private boolean sex = false;
    private int level = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeUTF(this.playerName);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
    }

    public void deserialize(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of DungeonPartyFinderPlayer.playerId.");
         }
         this.playerName = param1.readUTF();
         this.breed = param1.readByte();
         if(this.breed < PlayableBreedEnum.Feca || this.breed > PlayableBreedEnum.Ouginak)
         {
            throw new Exception("Forbidden value (" + this.breed + ") on element of DungeonPartyFinderPlayer.breed.");
         }
         this.sex = param1.readBoolean();
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of DungeonPartyFinderPlayer.level.");
         }
    }

}