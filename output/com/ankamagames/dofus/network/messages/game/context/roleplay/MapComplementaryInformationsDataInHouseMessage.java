package package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformationsInside;
import com.ankamagames.dofus.network.types.game.house.HouseInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.dofus.network.types.game.interactive.InteractiveElement;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.dofus.network.types.game.interactive.MapObstacle;
import com.ankamagames.dofus.network.types.game.context.fight.FightCommonInformations;
import com.ankamagames.dofus.network.types.game.context.fight.FightStartingPositions;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapComplementaryInformationsDataInHouseMessage extends MapComplementaryInformationsDataMessage implements INetworkMessage {

    private int protocolId = 6130;
    private boolean _isInitialized = false;
    private HouseInformationsInside currentHouse = ;
    private FuncTree _currentHousetree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6130;
    }

    public MapComplementaryInformationsDataInHouseMessage initMapComplementaryInformationsDataInHouseMessage(int param1,int  param2,Vector.<HouseInformations>  param3,Vector.<GameRolePlayActorInformations>  param4,Vector.<InteractiveElement>  param5,Vector.<StatedElement>  param6,Vector.<MapObstacle>  param7,Vector.<FightCommonInformations>  param8,boolean  param9,FightStartingPositions  param10,HouseInformationsInside  param11) {
         super.initMapComplementaryInformationsDataMessage(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10);
         this.currentHouse = param11;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.currentHouse = new HouseInformationsInside();
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
         this.serializeAs_MapComplementaryInformationsDataInHouseMessage(param1);
    }

    public void serializeAs_MapComplementaryInformationsDataInHouseMessage(ICustomDataOutput param1) {
         super.serializeAs_MapComplementaryInformationsDataMessage(param1);
         this.currentHouse.serializeAs_HouseInformationsInside(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapComplementaryInformationsDataInHouseMessage(param1);
    }

    public void deserializeAs_MapComplementaryInformationsDataInHouseMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.currentHouse = new HouseInformationsInside();
         this.currentHouse.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapComplementaryInformationsDataInHouseMessage(param1);
    }

    public void deserializeAsyncAs_MapComplementaryInformationsDataInHouseMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._currentHousetree = param1.addChild(this._currentHousetreeFunc);
    }

    private void _currentHousetreeFunc(ICustomDataInput param1) {
         this.currentHouse = new HouseInformationsInside();
         this.currentHouse.deserializeAsync(this._currentHousetree);
    }

}