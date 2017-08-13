package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.DungeonPartyFinderPlayer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class DungeonPartyFinderRoomContentMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6247;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private Vector<DungeonPartyFinderPlayer> players;
    private FuncTree _playerstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6247;
    }

    public DungeonPartyFinderRoomContentMessage initDungeonPartyFinderRoomContentMessage(int param1,Vector<DungeonPartyFinderPlayer>  param2) {
         this.dungeonId = param1;
         this.players = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dungeonId = 0;
         this.players = new Vector.<DungeonPartyFinderPlayer>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_DungeonPartyFinderRoomContentMessage(param1);
    }

    public void serializeAs_DungeonPartyFinderRoomContentMessage(ICustomDataOutput param1) {
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
         this.deserializeAs_DungeonPartyFinderRoomContentMessage(param1);
    }

    public void deserializeAs_DungeonPartyFinderRoomContentMessage(ICustomDataInput param1) {
         DungeonPartyFinderPlayer _loc4_ = null;
         this._dungeonIdFunc(param1);
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

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DungeonPartyFinderRoomContentMessage(param1);
    }

    public void deserializeAsyncAs_DungeonPartyFinderRoomContentMessage(FuncTree param1) {
         param1.addChild(this._dungeonIdFunc);
         this._playerstree = param1.addChild(this._playerstreeFunc);
    }

    private void _dungeonIdFunc(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of DungeonPartyFinderRoomContentMessage.dungeonId.");
         }
    }

    private void _playerstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._playerstree.addChild(this._playersFunc);
            _loc3_++;
         }
    }

    private void _playersFunc(ICustomDataInput param1) {
         DungeonPartyFinderPlayer _loc2_ = new DungeonPartyFinderPlayer();
         _loc2_.deserialize(param1);
         this.players.push(_loc2_);
    }

}