package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildFightPlayersEnemiesListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5928;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private CharacterMinimalPlusLookInformations[] playerInfo;
    private FuncTree _playerInfotree;


    public void serialize(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeInt(this.fightId);
         param1.writeShort(this.playerInfo.length);
         int _loc2_ = 0;
         while(_loc2_ < this.playerInfo.length)
         {
            (this.playerInfo[_loc2_] as CharacterMinimalPlusLookInformations).serializeAs_CharacterMinimalPlusLookInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         CharacterMinimalPlusLookInformations _loc4_ = null;
         this.fightId = param1.readInt();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GuildFightPlayersEnemiesListMessage.fightId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new CharacterMinimalPlusLookInformations();
            _loc4_.deserialize(param1);
            this.playerInfo.push(_loc4_);
            _loc3_++;
         }
    }

}