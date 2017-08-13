package package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterLightInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;

public class MapRunningFightDetailsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5751;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private Vector.<GameFightFighterLightInformations> attackers = ;
    private Vector.<GameFightFighterLightInformations> defenders = ;
    private FuncTree _attackerstree = ;
    private FuncTree _defenderstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private GameFightFighterLightInformations _loc7_ = null;
    private int _loc8_ = 0;
    private GameFightFighterLightInformations _loc9_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private GameFightFighterLightInformations _loc3_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations,_loc2_);
    private int _loc3_ = 0;
    private GameFightFighterLightInformations _loc3_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5751;
    }

    public MapRunningFightDetailsMessage initMapRunningFightDetailsMessage(int param1,Vector.<GameFightFighterLightInformations>  param2,Vector.<GameFightFighterLightInformations>  param3) {
         this.fightId = param1;
         this.attackers = param2;
         this.defenders = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.attackers = new Vector.<GameFightFighterLightInformations>();
         this.defenders = new Vector.<GameFightFighterLightInformations>();
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
         this.serializeAs_MapRunningFightDetailsMessage(param1);
    }

    public void serializeAs_MapRunningFightDetailsMessage(ICustomDataOutput param1) {
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapRunningFightDetailsMessage(param1);
    }

    public void deserializeAs_MapRunningFightDetailsMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         GameFightFighterLightInformations _loc7_ = null;
         int _loc8_ = 0;
         GameFightFighterLightInformations _loc9_ = null;
         this._fightIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations,_loc6_);
            _loc7_.deserialize(param1);
            this.attackers.push(_loc7_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapRunningFightDetailsMessage(param1);
    }

    public void deserializeAsyncAs_MapRunningFightDetailsMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         this._attackerstree = param1.addChild(this._attackerstreeFunc);
         this._defenderstree = param1.addChild(this._defenderstreeFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element of MapRunningFightDetailsMessage.fightId.");
    }

    private void _attackerstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._attackerstree.addChild(this._attackersFunc);
            _loc3_++;
    }

    private void _attackersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         GameFightFighterLightInformations _loc3_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.attackers.push(_loc3_);
    }

    private void _defenderstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._defenderstree.addChild(this._defendersFunc);
            _loc3_++;
    }

    private void _defendersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         GameFightFighterLightInformations _loc3_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.defenders.push(_loc3_);
    }

}