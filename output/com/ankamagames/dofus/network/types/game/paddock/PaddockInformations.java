package package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockInformations extends Object implements INetworkType {

    private int protocolId = 132;
    private int maxOutdoorMount = 0;
    private int maxItems = 0;


    public int getTypeId() {
         return 132;
    }

    public PaddockInformations initPaddockInformations(int param1,int  param2) {
         this.maxOutdoorMount = param1;
         this.maxItems = param2;
         return this;
    }

    public void reset() {
         this.maxOutdoorMount = 0;
         this.maxItems = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PaddockInformations(param1);
    }

    public void serializeAs_PaddockInformations(ICustomDataOutput param1) {
         if(this.maxOutdoorMount < 0)
            throw new Exception("Forbidden value (" + this.maxOutdoorMount + ") on element maxOutdoorMount.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockInformations(param1);
    }

    public void deserializeAs_PaddockInformations(ICustomDataInput param1) {
         this._maxOutdoorMountFunc(param1);
         this._maxItemsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockInformations(param1);
    }

    public void deserializeAsyncAs_PaddockInformations(FuncTree param1) {
         param1.addChild(this._maxOutdoorMountFunc);
         param1.addChild(this._maxItemsFunc);
    }

    private void _maxOutdoorMountFunc(ICustomDataInput param1) {
         this.maxOutdoorMount = param1.readVarUhShort();
         if(this.maxOutdoorMount < 0)
            throw new Exception("Forbidden value (" + this.maxOutdoorMount + ") on element of PaddockInformations.maxOutdoorMount.");
    }

    private void _maxItemsFunc(ICustomDataInput param1) {
         this.maxItems = param1.readVarUhShort();
         if(this.maxItems < 0)
            throw new Exception("Forbidden value (" + this.maxItems + ") on element of PaddockInformations.maxItems.");
    }

}