package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.DungeonPartyFinderPlayer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class DungeonPartyFinderRoomContentUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6250;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private Vector.<DungeonPartyFinderPlayer> addedPlayers = ;
    private Vector.<Number> removedPlayersIds = ;
    private FuncTree _addedPlayerstree = ;
    private FuncTree _removedPlayersIdstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private * _loc7_ = NaN;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6250;
    }

    public DungeonPartyFinderRoomContentUpdateMessage initDungeonPartyFinderRoomContentUpdateMessage(int param1,Vector.<DungeonPartyFinderPlayer>  param2,Vector.<Number>  param3) {
         this.dungeonId = param1;
         this.addedPlayers = param2;
         this.removedPlayersIds = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dungeonId = 0;
         this.addedPlayers = new Vector.<DungeonPartyFinderPlayer>();
         this.removedPlayersIds = new Vector.<Number>();
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
         this.serializeAs_DungeonPartyFinderRoomContentUpdateMessage(param1);
    }

    public void serializeAs_DungeonPartyFinderRoomContentUpdateMessage(ICustomDataOutput param1) {
         if(this.dungeonId < 0)
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DungeonPartyFinderRoomContentUpdateMessage(param1);
    }

    public void deserializeAs_DungeonPartyFinderRoomContentUpdateMessage(ICustomDataInput param1) {
         DungeonPartyFinderPlayer _loc6_ = null;
         * _loc7_ = NaN;
         this._dungeonIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = new DungeonPartyFinderPlayer();
            _loc6_.deserialize(param1);
            this.addedPlayers.push(_loc6_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DungeonPartyFinderRoomContentUpdateMessage(param1);
    }

    public void deserializeAsyncAs_DungeonPartyFinderRoomContentUpdateMessage(FuncTree param1) {
         param1.addChild(this._dungeonIdFunc);
         this._addedPlayerstree = param1.addChild(this._addedPlayerstreeFunc);
         this._removedPlayersIdstree = param1.addChild(this._removedPlayersIdstreeFunc);
    }

    private void _dungeonIdFunc(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of DungeonPartyFinderRoomContentUpdateMessage.dungeonId.");
    }

    private void _addedPlayerstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._addedPlayerstree.addChild(this._addedPlayersFunc);
            _loc3_++;
    }

    private void _addedPlayersFunc(ICustomDataInput param1) {
         DungeonPartyFinderPlayer _loc2_ = new DungeonPartyFinderPlayer();
         _loc2_.deserialize(param1);
         this.addedPlayers.push(_loc2_);
    }

    private void _removedPlayersIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._removedPlayersIdstree.addChild(this._removedPlayersIdsFunc);
            _loc3_++;
    }

    private void _removedPlayersIdsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readVarUhLong();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of removedPlayersIds.");
    }

}