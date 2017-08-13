package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.DungeonPartyFinderPlayer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DungeonPartyFinderRoomContentMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6247;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private DungeonPartyFinderPlayer[] players;
    private FuncTree _playerstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
         param1.writeShort(this.players.length);
         int _loc2_ = 0;
         while(_loc2_ < this.players.length)
         {
            (this.players[_loc2_] as DungeonPartyFinderPlayer).serializeAs_DungeonPartyFinderPlayer(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         DungeonPartyFinderPlayer _loc4_ = null;
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of DungeonPartyFinderRoomContentMessage.dungeonId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new DungeonPartyFinderPlayer();
            _loc4_.deserialize(param1);
            this.players.push(_loc4_);
            _loc3_++;
         }
    }

}